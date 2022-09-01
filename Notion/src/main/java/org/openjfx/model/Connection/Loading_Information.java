package org.openjfx.model.Connection;

import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import org.openjfx.model.Loading_Properties;


import java.io.IOException;

public class Loading_Information extends Loading_Properties {
    public Loading_Information(TextField Workspace_Name_Entry, TextField Bot_Id_Entry, TextField Owner_Entry, TextField Token_Entry) throws IOException {
        super();
        Workspace_Name_Entry.setText(super.workspace_name);
        Bot_Id_Entry.setText(super.bot_id);
        Owner_Entry.setText(super.owner);
        Token_Entry.setText(super.token);
    }

    }
