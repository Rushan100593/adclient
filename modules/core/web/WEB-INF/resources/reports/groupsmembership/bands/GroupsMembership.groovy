import com.company.adclient.entity.activedirectory.User
import com.company.adclient.service.ActiveDirectoryService
import com.haulmont.cuba.core.global.AppBeans

/**
 * @author rushan
 * @since 14.01.2017
 */
ActiveDirectoryService activeDirectoryService = AppBeans.get(ActiveDirectoryService.class)
def result = []

activeDirectoryService.findAll(User.class).each {user ->
    result.add([
            'name': user.name,
            'groups' : getGroups(user),
            'account' : user.SAMAccountname
    ])
}

return result

static def getGroups(User user) {
    StringBuilder sb = new StringBuilder()
    user.groups.each {group ->
        if(sb.size() > 0)
            sb.append(", \n")
        sb.append(group.name)
    }
    return sb.toString()
}