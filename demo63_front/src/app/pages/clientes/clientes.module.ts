import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientesComponent } from './clientes.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
	declarations: [ClientesComponent],
	imports: [
		CommonModule,
		RouterModule.forChild([{ path: '', component: ClientesComponent }]),
		FormsModule,
		ReactiveFormsModule,
	],
})
export class ClientesModule {}
