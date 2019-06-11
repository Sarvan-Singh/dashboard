import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Person } from 'src/app/models/person';
import { PersonService } from 'src/app/services/person.service';

@Component({
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  query = new FormControl('');
  displayedColumns: string[] = ['id', 'firstName', 'lastName'];
  personContent: Person[];

  constructor(private service: PersonService) {
    //
  }

  ngOnInit(): void {
    //
  }

  onSearch(): void {
    let query: string = this.query.value as string;
    if (!query || query.trim() === "") {
      // nothing
      return;
    }
    this.service.search(query)
      .subscribe(data => {
        this.personContent = data.content.map((person, index) => {
          person.id = index + 1;
          return person;
        });
      });
  }

}
