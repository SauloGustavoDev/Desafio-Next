package saulodev.com.desafionext.viewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;;
import saulodev.com.desafionext.model.MainModel;

public class MainViewModel extends ViewModel {

    MainModel mainModel = new MainModel();

    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
    public LiveData<String> liveData = mutableLiveData;

    private MutableLiveData<String> mutableDigitado = new MutableLiveData<>();
    public LiveData<String> liveDataDigitado = mutableDigitado;

    public MutableLiveData<String> getMutableDigitado() {
        return mutableDigitado;
    }

    public void setMutableDigitado(String mutableDigitado) {
        this.mutableDigitado.setValue(mutableDigitado);
        mainModel.setNumero(Integer.parseInt(mutableDigitado));
    }

    public void passarResultado(){
        mutableLiveData.setValue(String.valueOf(mainModel.getResultado()));
    }

}

