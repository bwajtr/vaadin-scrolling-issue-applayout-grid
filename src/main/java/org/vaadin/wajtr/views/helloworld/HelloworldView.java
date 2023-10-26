package org.vaadin.wajtr.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.wajtr.views.MainLayout;

import java.util.UUID;

@PageTitle("Hello world")
@Route(value = "", layout = MainLayout.class)
public class HelloworldView extends VerticalLayout {

    public HelloworldView() {
        Div div = new Div();
        div.setHeight("300px");
        add(div);

        var grid = new Grid<>(Person.class, false);
        grid.setItems();
        grid.addColumn(Person::name)
                .setKey(UUID.randomUUID().toString()).setHeader("First name")
                .setSortable(true);

        grid.setItems(new Person("John"), new Person("Mary"), new Person("Joe"));
        grid.setAllRowsVisible(true);
        add(grid);

        Div divBelow = new Div();
        divBelow.setHeight("2000px");
        add(divBelow);
    }
}

record Person(String name) {
}


