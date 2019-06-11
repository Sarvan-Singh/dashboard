import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, PageEvent } from '@angular/material';
import { PageInfo } from '../../models/page';
import { Person } from '../../models/person';
import { PersonService } from '../../services/person.service';

@Component({
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'firstName', 'lastName'];
  personContent = new MatTableDataSource<Person>();

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private service: PersonService) {
    //
  }

  ngOnInit(): void {
    this.personContent.paginator = this.paginator;
    this.list(0, 10);
  }

  onPage(pageEvent: PageEvent): void {
    this.list(pageEvent.pageIndex, pageEvent.pageSize);
  }

  list(pageIndex: number, pageSize: number): void {
    this.service.list(pageIndex, pageSize)
      .subscribe(data => {
        let pageInfo: PageInfo = data.page;
        let offset: number = pageInfo.number * pageInfo.size + 1;
        // put id/index on person
        this.personContent = new MatTableDataSource<Person>(data.content.map((person, index) => {
          person.id = offset + index;
          return person;
        }));
        // update paginator
        this.paginator.length = data.page.totalElements;
        this.paginator.pageIndex = data.page.number;
        this.paginator.pageSize = data.page.size;
      });
  }

}
