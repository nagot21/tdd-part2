package br.com.alura.leilao.ui;

import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.alura.leilao.database.dao.UsuarioDAO;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaUsuarioAdapter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by IanNagot on 25/10/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class AtualizadorDeUsuarioTest {

    @Mock
    private RecyclerView recyclerView;

    @Mock
    private ListaUsuarioAdapter adapter;

    @Mock
    private UsuarioDAO dao;

    @Test
    public void deve_AtualizarListaDeUsuarios_QuandoSalvarUsuario() {

        AtualizadorDeUsuario atualizador = new AtualizadorDeUsuario(
                dao,
                adapter,
                recyclerView);

        Usuario alex = new Usuario("Alex");

        when(dao.salva(alex)).thenReturn(new Usuario(1, "Alex"));
        when(adapter.getItemCount()).thenReturn(1);

        atualizador.salva(alex);

        verify(dao).salva(new Usuario("Alex"));
        verify(adapter).adiciona(new Usuario(1, "Alex"));
        verify(recyclerView).smoothScrollToPosition(0);
    }
}
