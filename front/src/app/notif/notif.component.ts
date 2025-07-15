import { Component, OnInit } from '@angular/core';
import { NotificationService, NotificationMessage } from '../service/NotificationService';
@Component({
  selector: 'app-notif',
  templateUrl: './notif.component.html',
  styleUrls: ['./notif.component.css']
})
export class NotifComponent  implements OnInit{


  notifications: NotificationMessage[] = [];

  constructor(private notificationService: NotificationService) {}

  ngOnInit(): void {
    this.notificationService.notifications$.subscribe(notification => {
      this.notifications.push(notification);
      setTimeout(() => this.removeNotification(notification), 5000);
    });
  }

  private removeNotification(notification: NotificationMessage): void {
    this.notifications = this.notifications.filter(n => n !== notification);
  }
}


