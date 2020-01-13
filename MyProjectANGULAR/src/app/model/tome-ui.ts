import { ChapitreUI } from './chapitre-ui';
import { MangaUI } from './manga-ui';

export interface TomeUI {

    id:number;
    titre:string;
    numero:string;
    synopsis:string;
    dateDeSortieFR: Date;
    dateDeSortieJPN:Date;
    manga:MangaUI;
    chapitres:Array<ChapitreUI>;
}
