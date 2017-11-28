package com.example.diego.automaodeiluminao;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends AppCompatActivity {
    public TextView respostaServidor;

    private Button desligarBtn, ligarBtn;
    private EditText ipDoServidor, portaDoServidor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        respostaServidor = (TextView)findViewById(R.id.respostaServidor);

        ipDoServidor = (EditText)findViewById(R.id.enderecoIP);
        portaDoServidor = (EditText)findViewById(R.id.portaServer);

        desligarBtn = (Button)findViewById(R.id.btnDesligar);
        desligarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviaComando("2");
            }
        });
        ligarBtn = (Button)findViewById(R.id.btnLigar);
        ligarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviaComando("1");
            }
        });
    }

    public void enviaComando(final String mensagem){
        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    Socket socketServidor = new Socket(ipDoServidor.getText().toString(),
                            Integer.parseInt(portaDoServidor.getText().toString()));

                    OutputStream saida = socketServidor.getOutputStream();

                    PrintWriter pWriter = new PrintWriter(saida);
                    pWriter.print(mensagem);
                    pWriter.flush();

                    BufferedReader entrada = new BufferedReader(new InputStreamReader(socketServidor.getInputStream()));
                    final String mensagemServidor = entrada.readLine();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            respostaServidor.setText(("Do servidor: " + mensagemServidor));
                        }
                    });

                    saida.close();
                    pWriter.close();
                    socketServidor.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
