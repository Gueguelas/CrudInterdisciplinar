import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        PlanoPagamento plano = new PlanoPagamento();
        Administrador adm = new Administrador();
//        INSERIR
//        plano.inserirPlanoPagamento(1,"Cartão de crédito", "Platina", "Plano Platina", 140);

//        Buscar Plano_Pagamento
//        ResultSet rsbusca = plano.buscar();
//        try {
//            if(rsbusca.next()) {
//                String lista = ("sID " + rsbusca.getInt("SID") + "\nfValor: " + rsbusca.getDouble("FVALOR") + "\ncFormapagamento: " + rsbusca.getString("CFORMAPAGAMENTO") + "\ncTipoPlano: " + rsbusca.getString("CTIPOPLANO") + "\ncDescricao: " + rsbusca.getString("CDESCRICAO"));
//                System.out.println(lista);
//
//            }else{
//                System.out.println("Chave primaria não existe");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//
//        REMOVER
//        System.out.println(plano.remover(1));

//        INSERIR ADM
//        adm.inserirAdministrador(2, "Mkf", "aaa@gmail.com", "12345678");

//        BUSCAR ADM
        ResultSet rsbuscaadm = adm.buscar();
        try {
            if(rsbuscaadm != null) {
                while (rsbuscaadm.next()){
                String lista = ("sID: " + rsbuscaadm.getInt("SID") + "\ncNome: " + rsbuscaadm.getString("CNOME") + "\ncEmail: " + rsbuscaadm.getString("CEMAIL") + "\ncSenha: " + rsbuscaadm.getString("CSENHA")+"\n=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println(lista);
                }

            }else{
                System.out.println("Tabela vazia");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}