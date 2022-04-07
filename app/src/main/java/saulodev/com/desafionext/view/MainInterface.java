package saulodev.com.desafionext.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import saulodev.com.desafionext.viewModel.MainViewModel;
import saulodev.com.desafionext.databinding.ActivityMainBinding;

public class MainInterface extends AppCompatActivity{
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mainViewModel =new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = binding.edtText.getText().toString();
                mainViewModel.setMutableDigitado(numero);
                mainViewModel.passarResultado();
                binding.setViewModel(mainViewModel);
                mainViewModel.visibilidade(binding.textoResultado);
            }
        });
    }
}