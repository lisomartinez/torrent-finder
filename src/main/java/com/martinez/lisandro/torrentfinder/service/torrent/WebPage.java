package com.martinez.lisandro.torrentfinder.service.torrent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WebPage {
    private String content;

    public WebPage() {
    }

    public String getContent() {
        return content;
    }

    public WebPage setContent(String content) {
        this.content = content;
        return this;
    }
}
