import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
	selector: 'app-clientes',
	templateUrl: './clientes.component.html',
	styleUrls: ['./clientes.component.scss'],
})
export class ClientesComponent implements OnInit {

	form: FormGroup;
	clientes: any[] = [];
	operacion = 1;

	constructor(
		private _clienteService: ClienteService,
	) {
		this.form = new FormGroup({
			codigo: new FormControl(null, [Validators.required]),
			dni: new FormControl(null, [Validators.required]),
			nombre: new FormControl(null, [Validators.required]),
			direccion: new FormControl(null, [Validators.required]),
		})
	}

	ngOnInit(): void {
		this.obtenerClientes();
	}

	registrarCliente() {
		const cliente = this.form.getRawValue();

		this._clienteService.saveCliente(cliente).subscribe((res: any) => {
			this.form.reset();
			this.operacion = 1;
			this.obtenerClientes();
		})
	}

	obtenerClientes() {
		this._clienteService.getClientes().subscribe((res: any) => {
			this.clientes = res;
		});
	}

	eliminarCliente(codigo: any) {
		this._clienteService.deleteCliente(codigo).subscribe((res: any) => {
			this.obtenerClientes();
			this.form.reset();
		})
	}

	seleccionarCliente(cliente: any) {
		this.operacion = 2;

		this.form.patchValue(cliente);
	}

	actualizarCliente() {
		const cliente = this.form.getRawValue();

		this._clienteService.saveCliente(cliente).subscribe((res: any) => {
			this.form.reset();
			this.operacion = 1;
			this.obtenerClientes();
		})
	}

	registrarOperacion() {
		switch (this.operacion) {
			case 1:
				this.registrarCliente();
				break;
			case 2:
				this.actualizarCliente();
				break;
		}
	}

}
