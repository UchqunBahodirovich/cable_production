package cableapp.views.customer;

import org.springframework.beans.factory.annotation.Autowired;

import cableapp.backend.BackendService;
import cableapp.backend.Employee;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import cableapp.MainView;
@Route(value = "customer", layout = MainView.class)
@PageTitle("Customer")
@CssImport("styles/views/customer/customer-view.css")
public class CustomerView extends Div implements AfterNavigationObserver {

    @Autowired
    private BackendService service;
    private final Grid<Employee> grid;

    public CustomerView() {
        setId("customer-view");
        grid = new Grid<>();
        grid.setId("list");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        grid.setHeightFull();
        grid.addColumn(new ComponentRenderer<>(employee -> {
            H3 h3 = new H3(
                    employee.getLastname() + ", " + employee.getFirstname());
            Anchor anchor = new Anchor("mailto:" + employee.getEmail(),
                    employee.getEmail());
            anchor.getElement().getThemeList().add("font-size-xs");
            Div div = new Div(h3, anchor);
            div.addClassName("employee-column");
            return div;
        }));

        add(grid);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        grid.setItems(service.getEmployees());
    }
}
