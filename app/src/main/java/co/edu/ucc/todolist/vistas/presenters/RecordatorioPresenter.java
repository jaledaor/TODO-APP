package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.vistas.fragmentos.IRecordatorioFragmentView;

/**
 * Created by Karen on 24/10/2017.
 */

public class RecordatorioPresenter implements IRecordatorioPresenter{

    private IRecordatorioFragmentView view;

    public RecordatorioPresenter(IRecordatorioFragmentView view) {
        this.view = view;
    }

    @Override
    public void recordar(String email) {

        view.deshabilitarControles();
        view.mostrarProgress();

        try {
        } catch (Exception e) {
        }


    }
}
