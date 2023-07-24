import { product } from './../../model/product';
import { Component } from '@angular/core';
import { order } from 'src/app/model/order';
import { OrderServicesService } from 'src/app/services/order/order-services.service';
import { ProductServicesService } from 'src/app/services/product/product-services.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  order_model:order = new order()
  product_model:product = new product()

constructor(private product_services:ProductServicesService,private order_service:OrderServicesService){}
ngOnInit(): void {
  //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
  //Add 'implements OnInit' to the class.
  this.getAllProduct()
  this.getAllOrder()
}

getAllProduct(){
  return this.product_services.product_Info().subscribe(respo=>{
    console.log(respo);
  })
}

getAllOrder(){
  return this.order_service.Order_Info().subscribe(respo=>{
    console.log(respo)
  })
}

add(product:any,order:any){
  return this.product_services.createProduct(product).subscribe(
   respo=>{
    this.order_model.product_id = respo.product_id
    this.order_service.createOrder(order).subscribe(
      respond=>{
        console.log(respond)
      }
    )

   }
  )
}

  submit(){
      this.add(this.product_model,this.order_model)
  }
}
