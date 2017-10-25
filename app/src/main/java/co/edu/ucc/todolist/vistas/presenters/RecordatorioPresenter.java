package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.dominio.CallBackInteractor;
import co.edu.ucc.todolist.dominio.ILUsuario;
import co.edu.ucc.todolist.dominio.LUsuario;
import co.edu.ucc.todolist.vistas.fragmentos.IRecordatorioFragmentView;

/**
 * Created by Karen on 24/10/2017.
 */

public class RecordatorioPresenter implements IRecordatorioPresenter{

    private IRecordatorioFragmentView view;
    private ILUsuario lUsuario;

    public RecordatorioPresenter(IRecordatorioFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void recordar(String email) {

        view.deshabilitarControles();
        view.mostrarProgress();

        try {
            lUsuario.recordarUsuario(email, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarControles();
                    view.ocultarProgress();
                    view.finalizarRecordatorio();
                }

                @Override
                public void error(String error) {
                    view.deshabilitarControles();
                    view.ocultarProgress();
                    view.mostrarError(error);
                }
            });
        } catch (Exception e) {
            view.habilitarControles();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }


    }
}
