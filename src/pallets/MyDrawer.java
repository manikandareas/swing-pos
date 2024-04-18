/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pallets;

import gui.Dashboard;
import gui.Products;
import main.FormManager;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.drawer.component.menu.data.Item;
import raven.drawer.component.menu.data.MenuItem;
import raven.swing.AvatarIcon;

/**
 *
 * @author manik
 */
public class MyDrawer extends SimpleDrawerBuilder {

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData().setIcon(new AvatarIcon(getClass().getResource("/images/profile.jpeg"), 60, 60, 999))
                .setTitle("Vito  Andareas Manik")
                .setDescription("manik@gmail.com");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        MenuItem menus[] = new MenuItem[]{
            new Item.Label("MENU"),
            new Item("Dashboard", "dashboard.svg"),
            new Item("Products", "products.svg"),
            new Item("Transactions", "transactions.svg"),
            new Item("Supplier", "supplier.svg"),
            new Item("Member", "member.svg"),
            new Item("Employee", "employee.svg"),
            new Item("Settings", "settings.svg"),
            new Item("Quit", "exit.svg"),};
        return new SimpleMenuOption().setMenus(menus).setBaseIconPath("icons").setIconScale(0.02f).addMenuEvent(new MenuEvent() {
            @Override
            public void selected(MenuAction action, int[] ints) {
                int selectedMenuIndex = ints[0];
                switch (selectedMenuIndex) {
                    case 0:
                        FormManager.setShowedForm(new Dashboard());
                        break;
                    case 1:
                        FormManager.setShowedForm(new Products());
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        });
    }


    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }

}
