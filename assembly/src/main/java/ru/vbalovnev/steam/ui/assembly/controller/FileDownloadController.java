package ru.vbalovnev.steam.ui.assembly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vbalovnev.steam.ui.assembly.repository.RepositoryData;
import ru.vbalovnev.steam.ui.service.model.Game;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

@RestController
public class FileDownloadController {

    @Autowired
    private RepositoryData repositoryData;

    @RequestMapping(value="/download/{id}")
    public void downloadFile(HttpServletResponse response, @PathVariable("id") String id) throws IOException
    {

        Game game = repositoryData.get(id);
        String result;
        if(game == null){
            result = "Game info not found";
        } else{
           result = "Name: " + game.getName() + " (" + game.getYearOfRelease() + ")";
            result = result + "\n";
            result = result + game.getDescription();
        }
        response.setContentType("text/plain; charset=UTF-8");

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + id + ".txt\""));

        InputStream inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
