import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente';
import { AutorComponent } from './components/autor/autor';
import { CategoriaComponent } from './components/categoria/categoria';
import { LibroComponent } from './components/libro/libro';

const routes: Routes = [
  { path: '', component: ClienteComponent },
  { path: 'autor', component: AutorComponent },
  { path: 'categoria', component: CategoriaComponent },
  { path: 'libro', component: LibroComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}