import { AuteurUI } from './auteur-ui';
import { TomeUI } from './tome-ui';

export interface MangaUI {

    id:number;
    nom:string;
    auteur:AuteurUI;
    tomes:Array<TomeUI>;

}
