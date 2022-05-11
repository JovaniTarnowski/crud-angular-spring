export class Page<T> {
  content: T[] = [];
  last: boolean = false;
  totalElements: number = 0;
  totalPages: number = 0;
  size: number = 0;
  number: number = 0;
  numberOfElements: number = 0;
  sort: string = '';
  first: boolean = false;
}
