import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
	{ path: '', redirectTo: '/clientes', pathMatch: 'full' },
	{ path: 'clientes', loadChildren: () => import('./pages/clientes/clientes.module').then(m => m.ClientesModule) },
	{ path: '**', redirectTo: '/clientes', pathMatch: 'full' },
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule],
})
export class AppRoutingModule {}
