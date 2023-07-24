import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ProductServicesService {
  private product_details = environment.url + 'Product';
  constructor( private http:HttpClient ) { }


  product_Info():Observable<any>{
    return this.http.get(this.product_details + "/GetAllProduct");
  }

  getproduct_ById(id:any):Observable<any>{
    return this.http.get(this.product_details + "/getUserById/" + id);
  }

  updateProduct(id:any,data:any){
    return this.http.put(this.product_details+"/updateProduct"+id,data);
  }

  deleteProduct(id:any){
    return this.http.delete(this.product_details+"/deleteProduct"+id);
  }

  createProduct(data:any):Observable<any>{
    return this.http.post(this.product_details+"/CreateProduct",data);
  }
}
