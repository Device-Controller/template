package vislab.no.ntnu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class for controlling the specifics for devices in this package. Used to give user more control and options for the device other than the ones provided in the interfaces.
 * Methods in here will only be called from your own pages, our main one will not call these.
 */
@Controller
@RequestMapping("api/template")
public class TemplateController extends DeviceManager{

    /**
     * Method for turning a device with the give id on.
     * @param id the id for the device.
     * @return Spring responseEntity with HTTP Status and text explaining what happened.
     */
    //when a user goes to ../api/template/poweron?id=number will start this method
    @RequestMapping("poweron")
    public ResponseEntity<String> powerOn(@RequestParam("id") int id){
        getDevice(id).powerOn();
        return new ResponseEntity<>("device was powered on", HttpStatus.OK);
    }
    /**
     * Forwards the correct page if the id given is of a type matching in this package.
     * @param id the id for the device.
     * @return forward string for Spring to show the correct page.
     */
    @Override
    public String getDevicePage(int id) {
        if(getActiveDevices().get(id) instanceof DeviceImpl){
            return "forward:/deviceimpl.html";
        } else if (getActiveDevices().get(id) instanceof  ProjectorImpl){
            return "forward:/projectorimpl.html";
        }
            return super.getDevicePage(id);
    }
}
