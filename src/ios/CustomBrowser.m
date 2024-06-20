#import <Cordova/CDV.h>
#import <SafariServices/SafariServices.h>

@interface CustomBrowser : CDVPlugin
- (void)open:(CDVInvokedUrlCommand*)command;
@end

@implementation CustomBrowser

- (void)open:(CDVInvokedUrlCommand*)command {
    NSString* urlString = [command.arguments objectAtIndex:0];
    NSURL* url = [NSURL URLWithString:urlString];
    SFSafariViewController* safariViewController = [[SFSafariViewController alloc] initWithURL:url];
    [self.viewController presentViewController:safariViewController animated:YES completion:nil];
}

@end
