import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

export interface OrderItem {
  productId: string;
  quantity: number;
  price: number;
}

export interface Order {
  id: string;
  status: string;
  items: OrderItem[];
  customerId: string;
  createdAt: string;
  updatedAt: string;
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  orders: Order[] = [];
  selectedOrder?: Order;
  loading = false;
  error = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchOrders();
  }

  fetchOrders() {
    this.loading = true;
    this.http.get<Order[]>('http://localhost:8080/api/orders').subscribe({
      next: orders => {
        this.orders = orders;
        this.loading = false;
      },
      error: err => {
        this.error = 'Błąd pobierania zamówień';
        this.loading = false;
      }
    });
  }

  showOrder(order: Order) {
    this.selectedOrder = order;
  }
} 