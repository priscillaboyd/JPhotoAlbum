package fi.iki.jka;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JPhotoFrameTest{

    int expectedInterval;

    @Test
    public void verifyIfInterval5000WorksOnSlideShow() throws Exception {
        ActionEvent event = new ActionEvent("", 0, JPhotoMenu.A_SLIDESHOW);
        JPhotoFrame frame = new JPhotoFrame(){
            @Override
            public void runSlideShow(int interval) {
                expectedInterval = interval;
            }

            @Override
            public void setTitle() {
                //we don't care about the title, so let's leave it empty
            }
        };
        frame.actionPerformed(event);
        assertEquals(5000, expectedInterval);
    }

    @Test
    public void verifyIfFasterIntervalIsUsedForSlideShow() throws Exception{
        ActionEvent event = new ActionEvent("", 0, JPhotoMenu.A_FAST_SLIDESHOW);
        JPhotoFrame frame = new JPhotoFrame(){

            @Override
            public void runSlideShow(int interval) {
                expectedInterval = interval;
            }

            @Override
            public void setTitle() {
                //we don't care about the title, so let's leave it empty
            }
        };
        frame.actionPerformed(event);
        assertEquals(2000, expectedInterval);
    }


}

