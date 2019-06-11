export class Page<T> {
  lisks: any;
  content: T[];
  page: PageInfo;
}

export class PageInfo {
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}
