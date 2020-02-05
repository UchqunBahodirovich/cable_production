package cableapp.views.productaion;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import cableapp.MainView;
@Route(value = "production", layout = MainView.class)
@PageTitle("Productaion")
@CssImport("styles/views/productaion/productaion-view.css")
public class ProductaionView extends Div {

    public ProductaionView() {
        setId("productaion-view");
        add(new Label("Content placeholder"));
    }

}
