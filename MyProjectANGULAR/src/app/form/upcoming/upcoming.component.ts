import { Component, OnInit } from '@angular/core';
import { TomeUI } from 'src/app/model/tome-ui';
import { TomeService } from 'src/app/service/tome/tome.service';

@Component({
  selector: 'app-upcoming',
  templateUrl: './upcoming.component.html',
  styleUrls: ['./upcoming.component.css']
})
export class UpcomingComponent implements OnInit {

  tomes:TomeUI[]=[];

  constructor(private tomeService: TomeService) { }

  ngOnInit() {
    this.tomeService.getAll().subscribe(values => {this.tomes = values;}); //values._embedded.todos
  }

}
