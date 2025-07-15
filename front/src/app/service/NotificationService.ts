import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private notificationsSubject = new Subject<NotificationMessage>();
  notifications$ = this.notificationsSubject.asObservable();

  notify(message: string, type: NotificationType = 'info'): void {
    const notification: NotificationMessage = { message, type };
    this.notificationsSubject.next(notification);
  }
}

export type NotificationType = 'success' | 'error' | 'info' | 'warning';

export interface NotificationMessage {
  message: string;
  type: NotificationType;
}
