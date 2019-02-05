package com.age.saudeocupacionalWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExameServiceImpl implements ExameService {
	private List<Exame> exames;
	
	public Exame[] buscarTodosExames() throws Exception  {
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost/age";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "");
	         
	         StringBuilder sbSQL = new StringBuilder();
	         sbSQL.append(" SELECT ");
	         sbSQL.append(" 	F.NOME, ");
	         sbSQL.append("     F.CARGO, ");
	         sbSQL.append("     TE.DESCRICAO, ");
	         sbSQL.append("     E.DATA_EXAME, ");
	         sbSQL.append("     E.PARECER_MEDICO, ");
	         sbSQL.append("     E.DATA_EMISSAO_ASO ");
	         sbSQL.append(" FROM EXAME E ");
	         sbSQL.append(" INNER JOIN TIPO_EXAME TE ON TE.ID = E.ID_TIPO_EXAME ");
	         sbSQL.append(" INNER JOIN FUNCIONARIO F ON F.ID = E.id_funcionario ");
	         
	         PreparedStatement ps = conn.prepareStatement(sbSQL.toString());
	         ResultSet rs = ps.executeQuery();

	         exames = new ArrayList<Exame>();
	         
	         while (rs.next()) {
	        	 Exame exame = new Exame();
	        	 Funcionario funcionario = new Funcionario();
	        	 TipoExame tipoExame = new TipoExame();
	        	 
	        	 funcionario.setNome(rs.getString(1));
	        	 funcionario.setCargo(rs.getString(2));
	        	 tipoExame.setDescricao(rs.getString(3));
	        	 exame.setDataExame(rs.getDate(4));
	        	 exame.setParecerMedico(rs.getString(5));
	        	 exame.setDataEmissaoAso(rs.getDate(6));
	        	 
	        	 exame.setTipoExame(tipoExame.getDescricao());
	        	 exame.setFuncionario(funcionario);
	        	 
	        	 exames.add(exame);
	         }
	         
	         Exame[] exame = exames.toArray(new Exame[exames.size()]);
	      } catch (Exception e) {
	    	  throw e;
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return null;
	}
}
