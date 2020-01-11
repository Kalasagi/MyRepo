package com.myproject.rest.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.rest.dao.MangaDAO;
import com.myproject.rest.model.Auteur;
import com.myproject.rest.model.Chapitre;
import com.myproject.rest.model.Manga;
import com.myproject.rest.model.Tome;

@Component
public class MangaWikipediaUtil {
	
	private static final String CHAPITRES = "LISTE DES CHAPITRES";
	private static final String CHAPITRE = "CHAPITRE";
	private static final String SPACED_TWO_PTS = " : ";
	private static final String SPACE = " ";
	private static final String TAB =  "\t";
	private static final String LEFT_PARENT =  " \\(";
	
	private static Map<String,Integer> mois = new HashMap<>();

	static {

		mois.put("janvier",  Calendar.JANUARY);
		mois.put("février",  Calendar.FEBRUARY);
		mois.put("mars",  Calendar.MARCH);
		mois.put("avril", Calendar.JANUARY);
		mois.put("mai",  Calendar.MAY);
		mois.put("juin",  Calendar.JUNE);
		mois.put("juillet",  Calendar.JULY);
		mois.put("août",  Calendar.AUGUST);
		mois.put("septembre",  Calendar.SEPTEMBER);
		mois.put("octobre",  Calendar.OCTOBER);
		mois.put("novembre",  Calendar.NOVEMBER);
		mois.put("décembre",  Calendar.DECEMBER);
	}

	private static MangaDAO mangaDao;
	
	@Autowired
	private MangaDAO mangaDaoNS;

	@PostConstruct     
	private void initStaticDao () {
	  mangaDao = mangaDaoNS;
	}
	
	private MangaWikipediaUtil() {
	}
	
	public static void parse(String fileName) {
		
		String filePath = ClassLoader.getSystemClassLoader().getResource(fileName).getFile();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			Manga manga = new Manga();
			List<Tome> tomes = new ArrayList<>();
			manga.setTomes(tomes);
			manga.setNom(reader.readLine());
			
			Auteur auteur = new Auteur();
			auteur.setPseudo(reader.readLine());
			manga.setAuteur(auteur);
			
			reader.readLine();
			
			String line  = reader.readLine();
			while (line != null) {
				
				// TOME
				Tome tome = getTome(line);
				tomes.add(tome);
				
				List<Chapitre> chapitres = new ArrayList<>();
				tome.setChapitres(chapitres);
				
				line = reader.readLine();
				
				if(line != null && !line.isEmpty())
				{
				
					// CHAPITRES
					if(line.toUpperCase().contains(CHAPITRES))
					{
						line = reader.readLine();
						
						while(line.toUpperCase().contains(CHAPITRE))
						{
							chapitres.add(getChapitre(line));
							line = reader.readLine();
						}			
					}
	
					// SYNOPSIS
					String synopsis = null;
					
					while(!line.isEmpty())
					{
						synopsis += line == null ? line : SPACE + line;
						line = reader.readLine();
					}
					
					tome.setSynopsis(synopsis);
				
				}
				
				line = reader.readLine();
			}
			
			mangaDao.create(manga);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static Tome getTome(String line) {
		// 1	2 décembre 2016ja 1	978-4-08-880872-7ja 1	25 avril 2018fr 1	978-2-8203-3223-3fr 1
		
		Tome tome = new Tome();
		String splitTab[] = line.replace(TAB, SPACE).split(SPACE);
		tome.setNumero(splitTab[0]);
		tome.setDateDeSortieJPN(getDate(splitTab[1],splitTab[2],splitTab[3].substring(0, 4)));
		
		if(splitTab.length > 10)
		{
			tome.setDateDeSortieFR(getDate(splitTab[7],splitTab[8],splitTab[9].substring(0, 4)));
		}

		return tome;
	}

	private static Date getDate(String day, String strMonth, String year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, mois.get(strMonth));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		return cal.getTime();
	}

	private static Chapitre getChapitre(String line) {
		
		// Chapitre 8 : J'ai une idée ! (0) (考えがある, Kangae ga aru?)
		Chapitre chapitre = new Chapitre();
		String splitTab[] = line.split(SPACED_TWO_PTS);
		chapitre.setNumero(splitTab[0].split(SPACE)[1]);
		chapitre.setTitre(splitTab[1].split(LEFT_PARENT)[0]);
		
		return chapitre;
	}

}
