import { Route, Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CoursesService } from './../services/courses.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup;
  id: number = 0;

  constructor(private formBuilder: FormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location,
    private activatedRoute: ActivatedRoute,) {

    this.form = this.formBuilder.group({
      id: [null],
      name: [null],
      category: [null]
    });

    if (this.activatedRoute.snapshot.url[0].path == 'edit') {
        this.activatedRoute.params.subscribe(param => {
          const id = param['id'];

          this.service.findById(id).subscribe(
            res => {
              this.form.patchValue(res);
            }
          );

      });

    }

  }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.save(this.form.value).subscribe(result => this.onSucess(), error => this.onError());
  }

  onCancel(){
    this.location.back();
  }

  private onSucess(){
    this.snackBar.open('Curso Salvo com Sucesso!', '', {duration: 5000});
    this.onCancel();
  }

  private onError(){
    this.snackBar.open('Erro ao slavar curso.', '', {duration: 5000});
  }

}
