package com.example.umaiuniverse.ui.cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.umaiuniverse.databinding.FragmentCardapioBinding;

public class CardapioFragment extends Fragment {

    private FragmentCardapioBinding binding;
    private int contadorCreme = 0;
    private int contadorBatata = 0;
    private int contadorMorango = 0;
    private int contadorDocinhos = 0;
    private int contadorPizza = 0;

    public void subtraiCreme() {
        if(contadorCreme > 0){
            contadorCreme--;
            binding.textCreme.setText(String.valueOf(contadorCreme));
        }

    }
    public void addCreme(){
        contadorCreme++;
        binding.textCreme.setText(String.valueOf(contadorCreme));
    }
    public void limparC(){
        contadorCreme = 0;
        binding.textCreme.setText(String.valueOf(contadorCreme));
    }

    //Batata
    public void subtraiBatata() {
        if(contadorBatata > 0){
            contadorBatata--;
            binding.textBatata.setText(String.valueOf(contadorBatata));
        }

    }
    public void addBatata(){
        contadorBatata++;
        binding.textBatata.setText(String.valueOf(contadorBatata));
    }
    public void limparB(){
        contadorBatata = 0;
        binding.textBatata.setText(String.valueOf(contadorBatata));
    }

    //Morango
    public void subtraiMorango() {
        if(contadorMorango > 0){
            contadorMorango--;
            binding.textMorango.setText(String.valueOf(contadorMorango));
        }

    }
    public void addMorango(){
        contadorMorango++;
        binding.textMorango.setText(String.valueOf(contadorMorango));
    }
    public void limparM(){
        contadorMorango = 0;
        binding.textMorango.setText(String.valueOf(contadorMorango));
    }

    //Docinho
    public void subtraiDocinho() {
        if(contadorDocinhos > 0){
            contadorDocinhos--;
            binding.textDocinho.setText(String.valueOf(contadorDocinhos));
        }

    }
    public void addDocinho(){
        contadorDocinhos++;
        binding.textDocinho.setText(String.valueOf(contadorDocinhos));
    }
    public void limparD(){
        contadorDocinhos = 0;
        binding.textDocinho.setText(String.valueOf(contadorDocinhos));
    }

    //Pizza
    public void subtraiPizza() {
        if(contadorPizza > 0){
            contadorPizza--;
            binding.textPizza.setText(String.valueOf(contadorPizza));
        }

    }
    public void addPizza(){
        contadorPizza++;
        binding.textPizza.setText(String.valueOf(contadorPizza));
    }
    public void limparP(){
        contadorPizza = 0;
        binding.textPizza.setText(String.valueOf(contadorPizza));
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CardapioViewModel cardapioViewModel =
                new ViewModelProvider(this).get(CardapioViewModel.class);

        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Creme
        binding.buttonMinus2.setOnClickListener(v -> subtraiCreme());
        binding.buttonPlus2.setOnClickListener(v -> addCreme());
        binding.comprarCreme.setOnClickListener(v -> limparC());

        //Batata
        binding.buttonMinus4.setOnClickListener(v -> subtraiBatata());
        binding.buttonPlus4.setOnClickListener(v -> addBatata());
        binding.comprarBatata.setOnClickListener(v -> limparB());

        //Morango
        binding.buttonMinus1.setOnClickListener(v -> subtraiMorango());
        binding.buttonPlus1.setOnClickListener(v -> addMorango());
        binding.comprarMorango.setOnClickListener(v -> limparM());

        //Docinhos
        binding.buttonMinus3.setOnClickListener(v -> subtraiDocinho());
        binding.buttonPlus3.setOnClickListener(v -> addDocinho());
        binding.comprarDocinho.setOnClickListener(v -> limparD());

        //Pizza
        binding.buttonMinus5.setOnClickListener(v -> subtraiPizza());
        binding.buttonPlus5.setOnClickListener(v -> addPizza());
        binding.comprarPizza.setOnClickListener(v -> limparP());

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}