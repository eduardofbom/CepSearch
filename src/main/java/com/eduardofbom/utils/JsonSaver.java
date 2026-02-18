package com.eduardofbom.utils;

import com.eduardofbom.model.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonSaver {
    private String fileName;

    public JsonSaver(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void save(List<Address> addressList) {
        try (FileWriter writer = new FileWriter(this.fileName)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String jsonAddressList = gson.toJson(addressList);
            writer.write(jsonAddressList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
