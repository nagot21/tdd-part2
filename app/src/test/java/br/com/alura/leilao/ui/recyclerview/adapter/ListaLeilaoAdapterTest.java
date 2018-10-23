package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.leilao.model.Leilao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by IanNagot on 23/10/2018
 */

@RunWith(MockitoJUnitRunner.class)
public class ListaLeilaoAdapterTest {

    @Mock
    private Context context = Mockito.mock(Context.class);

    @Spy
    private ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(context);

    @Test
    public void deve_AtualizarListaDeLeiloes_QuandoReceberListDeLeiloes(){

        //MockitoAnnotations.initMocks(this); //Same as @RunWith(MockitoJUnitRunner.class)

        Mockito.doNothing().when(adapter).atualizaLista();

        adapter.atualiza(new ArrayList<>(Arrays.asList(
                new Leilao("Console"),
                new Leilao("Computador"))));

        Mockito.verify(adapter).atualizaLista();

        assertThat(adapter.getItemCount(), is(2));
    }
}