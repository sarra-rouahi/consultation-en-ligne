# 🩺 Consultation en Ligne — Online Medical Consultation Platform 

A full-featured  web application for managing online medical consultations — connecting **patients**, **doctors**, and **secretaries** through role-based dashboards, appointment scheduling, digital prescriptions, real-time notifications, and a browser-based **WebRTC video consultation** module.



---

## ✨ Key Features

- 🔐 **Role-based authentication** — three distinct user types (Patient, Doctor, Secretary), each with dedicated registration flows and protected dashboards (route guards).
- 📅 **Appointment lifecycle management** — request → review → accept/reject → complete, with dedicated views per role.
- 🧑‍⚕️ **Patient record management** — create, view, update, search, and delete patient profiles.
- 💊 **Digital prescriptions** — doctors can create and consult prescriptions per patient.
- 🔔 **Real-time notifications** — Socket.IO-powered live notifications plus a global RxJS notification bus for instant UI feedback (success/error/info/warning).
- 📹 **Video consultation** — in-browser peer-to-peer audio/video calls using native **WebRTC**, with no third-party plugin required.
- 💅 **Responsive UI** — built with Bootstrap 5 and Font Awesome, with SweetAlert2 for polished user feedback dialogs.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Framework | **Angular 16** (CLI 16.1.4) |
| Backend | Springboot |
| Language | **TypeScript** |
| Styling | Bootstrap 5, Font Awesome, custom CSS |
| HTTP Layer | `@angular/common/http` (`HttpClient`), RxJS |
| Real-time communication | `socket.io-client` |
| Video calls | Native **WebRTC** (`RTCPeerConnection`) |
| UX feedback | SweetAlert2 |


---




---

## 🧩 Domain Model

The application is built around a simple object model shared across the UI:

- **User** — base entity (id, name, email, password, phone, gender)
- **Patient**, **Doctor**, **Secretary** — extend `User` with role-specific fields (speciality/department for doctors, birthdate/address for patients, department for secretaries)
- **Appointment** — links a patient and a doctor with a date and a status (`requested → accepted → completed`)
- **Prescription** — links a patient and a doctor with prescription text

---




## 🔌  Back-end API 

The front-end was originally designed to consume a REST API (Spring Boot style) on `http://localhost:8080`, exposing endpoints such as:

- `POST /signin` — authentication
- `POST /ajouterUser` · `/ajouterPatient` · `/ajouterDoctor` · `/ajouterSecretary` — registration
- `GET /affichePatient` · `/afficheDoctoravecid` · `/afficheSecretaryavecid` · `/afficheUseravecid/:id` — fetch users
- `PUT /modifierpatient` · `DELETE /supprimepatient/:id` — update/delete patient
- `GET /afficheAppointment` · `POST /ajouterAppointment` · `PUT /modifierappointment` · `DELETE /supprimedoAppointment/:id` — appointment CRUD
- `POST /request` · `GET /requested` · `POST /accept/:id` · `GET /accepted` · `DELETE /complete/:id` — appointment workflow
- `GET /affichePres` · `GET /affichePresavecid/:id` · `POST /ajouterPres` · `PUT /modifierPres` · `DELETE /supprimePres/:id` — prescriptions



---


## 👩‍💻 Author

**Sarra Rouahi**
Electrical & Electronics Engineering student — Computer Vision, Embedded Systems & AI enthusiast.
