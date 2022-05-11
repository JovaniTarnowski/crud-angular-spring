import { PageEvent } from '@angular/material/paginator';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';
import { Page } from 'src/app/shared/Page';
import { Course } from './../model/course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = '/api/courses/';

  constructor(private httpClient: HttpClient) { }

  //TODO: Add pageable change to Page<>
  list(event?: PageEvent) {
    let params: HttpParams = new HttpParams();
    if (event == null) {
      params = params.append('size', '10');
    }else{
      params = params.append('size', event.pageSize);
      params = params.append('page', event.pageIndex);
    }
    return this.httpClient.get<Page<Course>>(this.API, {
      params
    })
    .pipe(
      first(),
    );
  }

  save(record: Course){
    return this.httpClient.post<Course>(this.API, record).pipe(first());
  }

  delete(record: Course){
    return this.httpClient.delete<Course>(this.API + `delete/${record.id}`);
  }

  update(record: Course){
    return this.httpClient.put<Course>(this.API + `update/${record.id}`, record);
  }

  findById(id: number){
    return this.httpClient.get<Course>(this.API + id)
  }

}
