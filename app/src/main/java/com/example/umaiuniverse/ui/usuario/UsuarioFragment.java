package com.example.umaiuniverse.ui.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.umaiuniverse.ConfigConta;
import com.example.umaiuniverse.Conta;
import com.example.umaiuniverse.Contato;
import com.example.umaiuniverse.EnderecoEntrega;
import com.example.umaiuniverse.MainActivity;
import com.example.umaiuniverse.MetodoPagamento;
import com.example.umaiuniverse.databinding.FragmentUsuarioBinding;

public class UsuarioFragment extends Fragment {

    private FragmentUsuarioBinding binding;

    public void logOut(View view){
        Intent intent = new Intent(requireContext(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }

    public void abrirConfigConta(View view) {
        Intent intent = new Intent(requireContext(), ConfigConta.class);
        startActivity(intent);
    }

    public void abrirEndereco(View view) {
        Intent intent = new Intent(requireContext(), EnderecoEntrega.class);
        startActivity(intent);
    }

    public void abrirmeioPag(View view) {
        Intent intent = new Intent(requireContext(), MetodoPagamento.class);
        startActivity(intent);
    }

    public void abrirContato(View view) {
        Intent intent = new Intent(requireContext(), Contato.class);
        startActivity(intent);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UsuarioViewModel usuarioViewModel =
                new ViewModelProvider(this).get(UsuarioViewModel.class);

        binding = FragmentUsuarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonLogout.setOnClickListener(v -> logOut(v));
        binding.buttonConfigConta.setOnClickListener(v -> abrirConfigConta(v));
        binding.buttonPagamento.setOnClickListener(v -> abrirmeioPag(v));
        binding.buttonEndereco.setOnClickListener(v -> abrirEndereco(v));
        binding.buttonContato.setOnClickListener(v -> abrirContato(v));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
