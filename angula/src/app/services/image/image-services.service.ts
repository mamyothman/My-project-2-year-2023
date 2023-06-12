import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ImageServicesService {
  // private images = environment.url + 'image';

  private url = "http://localhost:8080/api/file/upload";

  private url_2 = "http://localhost:8080/api/file/files";

  constructor( private http:HttpClient ) { }


  uploadFile(file: File): Observable<any> {
    const formData = new FormData();
    formData.append('file', file);

    return this.http.post(this.url, formData);
  }

  getAllFiles(): Observable<any> {
    return this.http.get(this.url_2);
  }
}
