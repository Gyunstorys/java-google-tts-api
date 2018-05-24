package google.tts.api.googlettsapi.controller;

import google.tts.api.googlettsapi.SynthesizeText;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TTSController {
    @RequestMapping("tts")
    public String getTTSBase64(String query,String lang) throws Exception {
        return "data:audio/mp3;base64,"+SynthesizeText.synthesizeText(query,lang);
    }
}
