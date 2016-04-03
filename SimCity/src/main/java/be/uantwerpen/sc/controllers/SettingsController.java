package be.uantwerpen.sc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Thomas on 03/04/2016.
 */
@Controller
public class SettingsController
{
    @RequestMapping(value = {"/settings", "/settings/server"})
    public String showServerSettings(ModelMap model)
    {
        return "protected/settings/serverSettings";
    }

    @RequestMapping(value = {"/settings/users"})
    public String showUsersSettings(ModelMap model)
    {
        return "protected/settings/usersSettings";
    }

    @RequestMapping(value = {"/settings/workers"})
    public String showWorkersSettings(ModelMap model)
    {
        return "protected/settings/workersSettings";
    }
}
