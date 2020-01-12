export interface TomeUI {

    id:number;
    titre:string;
    numero:string;
    synopsis:string;
    dateDeSortieFR: Date;
    dateDeSortieJPN:Date;
    manga:Manga;
    chapitres:Array<Chapitre>;
}
