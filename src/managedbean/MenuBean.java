	package managedbean;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean(name="menuBean")
public class MenuBean {

	private MenuModel model;

	public MenuBean() {
		model = new DefaultMenuModel();

		// Menu Inicial
		Submenu submenu = new Submenu();
		submenu.setLabel("Dados");

		MenuItem item = new MenuItem();
		item.setValue("Intermediação");
		item.setUrl("./paginas/totalEstado.xhtml");
		
		/*ActionListener listener = new ActionListener();
		ActionEvent event = new ActionEvent(event, 0, null);
		
		event.setSource("intermediacaoMB.listarEstado");
		listener.actionPerformed("intemediaçãoMB.salvar");
		
		item.
		item.addActionListener(listener);
		
		//"#{intermediacaoMB.listarEstado}"*/
		submenu.getChildren().add(item);
		
		item = new MenuItem();
		item.setValue("Seguro Desemprego");
		item.setUrl("../avaliacao/listaFormularios.jsf");
		submenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Carteira de Trabalho");
		item.setUrl("../avaliacao/avaliaDisciplina.jsf");
		submenu.getChildren().add(item);
		

		model.addSubmenu(submenu);

		// Second submenu
        submenu = new Submenu();
		submenu.setLabel("Administração");

		item = new MenuItem();
		item.setValue("Cadastramento de dados");
		item.setUrl("../../");
		submenu.getChildren().add(item);

//		item = new MenuItem();
//		item.setValue("Dynamic Menuitem 2.2");
//		item.setUrl("#");
//		submenu.getChildren().add(item);

		model.addSubmenu(submenu);
	}

	public MenuModel getModel() {
		return model;
	}

	public void save() {
		addMessage("Salvo");
	}

	public void update() {
		addMessage("Alterado");
	}

	public void delete() {
		addMessage("Removido");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}