package br.com.alura.leilao.ui;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

/**
 * Created by IanNagot on 25/10/2018
 */
public class AtualizadorDeLeiloes {

    public void buscaLeiloes(final ListaLeilaoAdapter adapter,
                             LeilaoWebClient client,
                             final ErroCarregaLeiloesListener erroListener) {

        client.todos(new RespostaListener<List<Leilao>>() {
            @Override
            public void sucesso(List<Leilao> leiloes) {
                adapter.atualiza(leiloes);
            }

            @Override
            public void falha(String mensagem) {
                erroListener.erroAoCarregar(mensagem);
            }
        });
    }

    public interface ErroCarregaLeiloesListener {
        void erroAoCarregar(String message);
    }
}