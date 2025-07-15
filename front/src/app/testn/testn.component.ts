import { Component } from '@angular/core';
import { NotificationService } from '../service/NotificationService';

@Component({
  selector: 'app-testn',
  templateUrl: './testn.component.html',
  styleUrls: ['./testn.component.css']
})
export class TestnComponent {
  constructor(private notificationService: NotificationService) {}

  notifySuccess(): void {
    this.notificationService.notify('This is a success notification!', 'success');
  }

  notifyError(): void {
    this.notificationService.notify('This is an error notification!', 'error');
  }

  notifyInfo(): void {
    this.notificationService.notify('This is an info notification!', 'info');
  }

  notifyWarning(): void {
    this.notificationService.notify('This is a warning notification!', 'warning');
  }
}
