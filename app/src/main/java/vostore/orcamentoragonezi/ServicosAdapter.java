package vostore.orcamentoragonezi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vostore.orcamentoragonezi.dominio.entidade.Servico;
import vostore.orcamentoragonezi.dominio.entidade.Servicos;

public class ServicosAdapter extends RecyclerView.Adapter<ServicosAdapter.ViewHolderServicos>{

    private List<Servicos> dados;

    public ServicosAdapter (List<Servicos> dados ){
        this.dados = dados;
    }
    @NonNull
    @Override
    public ServicosAdapter.ViewHolderServicos onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.linha_produtos,viewGroup,false);

        ViewHolderServicos holderServicos = new ViewHolderServicos(view);
        return holderServicos;
    }

    @Override
    public void onBindViewHolder(ServicosAdapter.ViewHolderServicos holder, int i) {


        if ((dados!= null ) && (dados.size() > 0)){
            Servicos servicos = dados.get(i);
            holder.txtNomeProduto.setText(servicos.nome);
            holder.txtValor.setText(servicos.preco.toString());
        }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderServicos extends RecyclerView.ViewHolder{

        public TextView txtNomeProduto;
        public TextView txtValor;

        public ViewHolderServicos(View itemView) {
            super(itemView);

            txtNomeProduto = itemView.findViewById(R.id.txtNomeProduto);
            txtValor = itemView.findViewById(R.id.txtValor);
        }
    }
}
