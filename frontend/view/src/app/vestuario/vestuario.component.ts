import { Component, OnInit } from '@angular/core';
import { Vestuario } from '../model/vestuario.module';
import { VestuarioService } from '../services/vestuario.service';

@Component({
  selector: 'app-vestuario',
  templateUrl: './vestuario.component.html',
  styleUrls: ['./vestuario.component.css']
})

export class VestuarioComponent implements OnInit {

  lista: Vestuario[] = [];
  obj: Vestuario = {
    id: 0,
    descricao: '',
    qtdeestoque: 0,
    tamanho: '',
    cor: '',
    datacad: ''
  };
  mens = '';

  constructor(private api: VestuarioService) { }

  ngOnInit() {
    this.consultar();
  }
  consultar() {
    this.api.consultar()
      .toPromise()
      .then
      (res => {
        this.lista = res;
      });
  }

  adicionar() {
    this.api.adicionar(this.obj)
      .toPromise()
      .then(vestuario => {
        this.mens = "Vestuario " + vestuario.descricao + " adicionada com sucesso";
        this.consultar();
      });
  }

  excluir() {
    this.api.excluir(this.obj.id)
      .toPromise()
      .then(vestuario => {
        this.mens = "Vestuario excluído com sucesso";
        this.consultar();
      });
  }

  alterar() {
    this.api.alterar(this.obj.id, this.obj)
      .toPromise()
      .then(vestuario => {
        this.mens = "Vestuario " + vestuario.descricao + " alterado com sucesso";
        this.consultar();
      });
  }
  
  carregarDados(v: Vestuario) {
    this.obj = v;
  }

}