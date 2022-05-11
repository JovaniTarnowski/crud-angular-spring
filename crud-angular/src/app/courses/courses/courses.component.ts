import { Location } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { Page } from 'src/app/shared/Page';
import { CoursesService } from '../services/courses.service';
import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { Course } from './../model/course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Page<Course>>;

  pageEvent: PageEvent = new PageEvent;
  pageIndex!:number;
  pageSize!:number;
  length!:number;

  displayedColumns = ['name', 'category', 'actions'];

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private service: CoursesService,
    private location: Location,
    private snackBar: MatSnackBar,
    private changeDetector: ChangeDetectorRef
    ) {

    this.courses$ = this.coursesService.list()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar cursos.')
        return of(new Page<Course>());
      })
    );

  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  onAdd(){
    this.router.navigate(['new'], {relativeTo: this.route})
  }

  onDelete(course: Course){
    this.service.delete(course).subscribe(result => {

      this.onSucess();

      this.courses$ = this.coursesService.list()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar cursos.')
          return of(new Page<Course>())
        })
      );
    }, error => console.log("not OKay!"));
  }

  onEdit(course: Course){
    this.router.navigate(['edit', course.id], {relativeTo: this.route});
  }

  private onSucess(){
    this.snackBar.open('Curso Deletado com Sucesso!', '', {duration: 5000});
  }

  load(event: PageEvent){
    this.courses$ = this.coursesService.list(event);
    this.courses$.subscribe(
      res => {
        this.pageIndex = res.number;
        this.pageSize = res.size;
        this.length = res.totalElements;
      }
    )
      return event;
  }

  ngOnInit(): void {

  }
}
