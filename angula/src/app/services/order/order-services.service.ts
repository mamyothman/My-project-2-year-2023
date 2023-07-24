import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class OrderServicesService {

  private product_details = environment.url + 'Order';
  constructor( private http:HttpClient ) { }


  Order_Info():Observable<any>{
    return this.http.get(this.product_details + "/GetAllOrder");
  }

  Order_ById(id:any):Observable<any>{
    return this.http.get(this.product_details + "/getUserById/" + id);
  }

  updateOrder(id:any,data:any){
    return this.http.put(this.product_details+"/updateOrder"+id,data);
  }

  deleteOrder(id:any){
    return this.http.delete(this.product_details+"/deleteOrder"+id);
  }

  createOrder(data:any):Observable<any>{
    return this.http.post(this.product_details+"/CreateOrder",data);
  }
}
